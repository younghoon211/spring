package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile { // 업로드 파일 정보 보관

    // 구분 이유 : 사용자가 같은 파일명 업로드 -> 서버에서 파일이 덮어씌워짐
    private String uploadFileName; // 고객이 업로드한 파일명
    private String storeFileName; // 서버에서 관리하는 파일명

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
