package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile(System.getProperty("user.dir") + "\\src\\main\\resources\\556.jpg");
        assertEquals(fileUploadPage.uploadedFilesText(), "screenshotes/556.jpg", "Wrong File Uploaded");
    }

}
