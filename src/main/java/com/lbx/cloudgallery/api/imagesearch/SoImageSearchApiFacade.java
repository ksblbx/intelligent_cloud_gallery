package com.lbx.cloudgallery.api.imagesearch;

import com.lbx.cloudgallery.api.imagesearch.model.SoImageSearchResult;
import com.lbx.cloudgallery.api.imagesearch.sub.GetSoImageListApi;
import com.lbx.cloudgallery.api.imagesearch.sub.GetSoImageUrlApi;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 360搜图图片搜索接口
 * <p>
 * 这里用了 门面模式
 */
@Slf4j
public class SoImageSearchApiFacade {

    /**
     * 搜索图片
     *
     * @param imageUrl 需要以图搜图的图片地址
     * @param start    开始下表
     * @return 图片搜索结果列表
     */
    public static List<SoImageSearchResult> searchImage(String imageUrl, Integer start) {
        String soImageUrl = GetSoImageUrlApi.getSoImageUrl(imageUrl);
        List<SoImageSearchResult> imageList = GetSoImageListApi.getImageList(soImageUrl, start);
        return imageList;
    }

    public static void main(String[] args) {
        // 测试以图搜图功能
        String imageUrl = "https://sansui-picture-1375842886.cos.ap-guangzhou.myqcloud" +
                ".com/picture/1959310706683785218/2025-09-03_KCpMOuiHDRnG55VE.";
        List<SoImageSearchResult> resultList = searchImage(imageUrl, 0);
        System.out.println("结果列表" + resultList);
    }
}
