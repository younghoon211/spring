package hello.upload.controller;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ItemForm { // 상품 저장용 폼

    private Long itemId;
    private String itemName;
    private MultipartFile attachFile; // 첨부파일
    private List<MultipartFile> imageFiles; // 이미지 다중 업로드 위해 MultipartFile 사용
}
