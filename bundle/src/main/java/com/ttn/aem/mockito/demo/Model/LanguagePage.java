package com.ttn.aem.mockito.demo.Model;

/**LanguagePage class is a POJO class,contains the getters
 * and setters of language Pages
 * version 1.0
 *
 */
public class LanguagePage {

    private String languagePageTitle;
    private String languagePagePath;
    private boolean currentPageFlag;

    public boolean isCurrentPageFlag() {
        return currentPageFlag;
    }

    public void setCurrentPageFlag(boolean currentPageFlag) {
        this.currentPageFlag = currentPageFlag;
    }

    public String getLanguagePageTitle() {
        return languagePageTitle;
    }

    public void setLanguagePageTitle(String languagePageTitle) {
        this.languagePageTitle = languagePageTitle;
    }

    public String getLanguagePagePath() {
        return languagePagePath;
    }

    public void setLanguagePagePath(String languagePagePath) {
        this.languagePagePath = languagePagePath;
    }

}

