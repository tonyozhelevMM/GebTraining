package amazonTests

import amazon.AmazonBasePage
import amazon.AmazonProfilePage
import amazon.AmazonSignInPasswordPage
import amazon.AmazonSignInPhoneOrEmailPage

class AmazonSpec extends BaseSpec {
    void "SignInToAmazonAndChangeProfileAndCoverPhotos"() {
        given: "User land on Amazon.com page"
            navigateToPage(AmazonBasePage.url)
            AmazonBasePage amazonBasePage = at AmazonBasePage
        when: "They click signIn button"
            amazonBasePage.clickAccountList()
        then: "They're relocated to log in page"
            AmazonSignInPhoneOrEmailPage amazonSignInPage = at AmazonSignInPhoneOrEmailPage
        when: "They enter their email or phone number they registered with"
            amazonSignInPage.fillPhoneOrEmailInputField("+359895464310")
            amazonSignInPage.clickContinueButton()
        then: "The go to the next log in page where the have to fill their password"
            AmazonSignInPasswordPage amazonSignInPasswordPage = at AmazonSignInPasswordPage
        when: "They fill their password"
            amazonSignInPasswordPage.fillPasswordInputField("Ap1YsN8p")
            amazonSignInPasswordPage.clickSignInButton()
        then: "They go back to the base page"
            amazonBasePage.isLoggedIn("Panayot")
        when: "Navigate to their profile"
            amazonBasePage.clickBrowsingHistory()
            amazonBasePage.clickYourProfileButton()
        then:
            AmazonProfilePage amazonProfilePage = at AmazonProfilePage
        when: "They upload their profile and cover photo"
            amazonProfilePage.uploadProfilePicture()
            amazonProfilePage.uploadBackGroundPicture()
        then: "They go back to the profile page"
            at AmazonProfilePage
    }
}
