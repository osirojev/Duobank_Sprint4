package utilities;

import org.openqa.selenium.support.PageFactory;

public class PageBase {

    public PageBase(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
}
