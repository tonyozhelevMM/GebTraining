package amazon

import geb.Page

class AmazonProfilePage extends Page{
    static at = {
        editYourProfileButton.isDisplayed()
    }

    static content = {
        editYourProfileButton                   {$("#customer-profile-name-header > div.a-row.name-header-footer-container > a > span > span > button")}
        uploadProfilePictureSelector            {$("#avatarUploadInput")}
        uploadBackGroundPictureSelector         {$("#coverUploadInput")}
    }

    void uploadProfilePicture() {
        File profilePicture = new File("src\\test\\resources\\profilePicture.jpg")
        uploadProfilePictureSelector << profilePicture.getAbsolutePath()
    }

    void uploadBackGroundPicture() {
        File backgroundPicture = new File("src\\test\\resources\\backgroundPicture.jpg")
        uploadBackGroundPictureSelector << backgroundPicture.getAbsolutePath()
    }
}
