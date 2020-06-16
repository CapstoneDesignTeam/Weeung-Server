package sms;

import model.request.*;
import model.response.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;

// ���� : https://docs.solapi.com/rest-api-reference/image-api
public interface SolapiImgApi {
	// �̹��� ���
	@POST("/images/v4/images")
	Call<ImageResult> createImage(@Header("Authorization") String auth, @Body ImageModel image);

	// �̹��� ���� ��������
	@GET("/images/v4/images/{imageId}")
	Call<ImageInfoResult> getImageInfo(@Header("Authorization") String auth, @Path("imageId") String imageId);

	// �̹��� ����Ʈ ��������
	@GET("/images/v4/images")
	Call<ArrayList<ImageListItem>> getImageList(@Header("Authorization") String auth);

	// �̹��� ����
	@DELETE("/images/v4/images/{imageId}")
	Call<DeleteImageResult> deleteImageInfo(@Header("Authorization") String auth, @Path("imageId") String imageId);
}
