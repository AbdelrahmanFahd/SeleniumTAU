package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {

    WebDriver driver;

    FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "file-upload")
    WebElement inputField;

    @FindBy(id = "file-submit")
    WebElement uploadButton;

    @FindBy(id = "uploaded-files")
    WebElement uploadFiles;

    public void clickUploadButton() {
        uploadButton.click();
    }

    /**
     *Provide path of the file to the form then clicks Upload Button
     * @param path The Complete path of the file to upload
     */
    public void uploadFile(String path) {
        inputField.sendKeys(path);
        clickUploadButton();
    }

    public String uploadedFilesText() {
        return uploadFiles.getText();
    }
}
