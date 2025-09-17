package com.lbx.cloudgallery.api.imagesearch.sub;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lbx.cloudgallery.api.imagesearch.model.SoImageSearchResult;
import com.lbx.cloudgallery.exception.BusinessException;
import com.lbx.cloudgallery.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取360搜图搜索的图片的列表
 */
@Slf4j
public class GetSoImageListApi {

    /**
     * 获取图片列表
     *
     * @param imageUrl 图片地址, 在 360 库中的地址
     * @return 图片列表对象
     */
    public static List<SoImageSearchResult> getImageList(String imageUrl, Integer start) {
        String url = "https://st.so.com/stu?a=mrecomm&start=" + start;
        Map<String, Object> formData = new HashMap<>();
        formData.put("img_url", imageUrl);
        HttpResponse response = HttpRequest.post(url)
                .form(formData)
                .timeout(5000)
                .execute();
        // 判断响应状态
        if (HttpStatus.HTTP_OK != response.getStatus()) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "搜图失败");
        }
        // 解析响应
        JSONObject body = JSONUtil.parseObj(response.body());
        // 处理响应结果
        if (!Integer.valueOf(0).equals(body.getInt("errno"))) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "搜图失败");
        }
        JSONObject data = body.getJSONObject("data");
        List<SoImageSearchResult> result = data.getBeanList("result", SoImageSearchResult.class);
        // 对结果进行处理, 因为返回的是分开的对象, 不是一个完整的图片路径, 这里需要自己拼接
        for (SoImageSearchResult soImageSearchResult : result) {
            String prefix;
            if (StrUtil.isNotBlank(soImageSearchResult.getHttps())) {
                prefix = "https://" + soImageSearchResult.getHttps() + "/";
            } else {
                prefix = "http://" + soImageSearchResult.getHttp() + "/";
            }
            soImageSearchResult.setImgUrl(prefix + soImageSearchResult.getImgkey());
        }
        return result;
    }

    public static void main(String[] args) {
        List<SoImageSearchResult> imageList = getImageList("https://sansui-picture-1375842886.cos.ap-guangzhou" +
                ".myqcloud.com/picture/1959310706683785218/2025-09-03_KCpMOuiHDRnG55VE.", 0);
        System.out.println("搜索结果: " + JSONUtil.parse(imageList));
    }

}

