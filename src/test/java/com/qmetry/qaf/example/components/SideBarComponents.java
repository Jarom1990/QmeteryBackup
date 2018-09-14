package com.qmetry.qaf.example.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
//import com.qmetry.qaf.example.steps.login;

public class SideBarComponents extends QAFWebComponent{
//	@FindBy(locator="lnk.travel")
//	private QAFWebElement lnkForTravel;
//
//	public QAFWebElement getLnkForTravel() {
//		return lnkForTravel;
//	}
//
//	public void setLnkForTravel(QAFWebElement lnkForTravel) {
//		this.lnkForTravel = lnkForTravel;
//	}

	public SideBarComponents(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(locator="list.sideBar")
	private QAFWebElement lnkForSidebar;
	public QAFWebElement getLnkForSidebar() {
		return lnkForSidebar;
	}

	public void setLnkForSidebar(QAFWebElement lnkForSidebar) {
		this.lnkForSidebar = lnkForSidebar;
	}
	@FindBy(locator="list.RandR.submenu")
	private QAFWebElement randrSubmenu;
	

public QAFWebElement getRandrSubmenu() {
		return randrSubmenu;
	}

	public void setRandrSubmenu(QAFWebElement randrSubmenu) {
		this.randrSubmenu = randrSubmenu;
	}
@FindBy(locator="login.loader.loc")
private QAFWebElement loginLoader;
public QAFWebElement getLoginLoader() {
	return loginLoader;
}

public void setLoginLoader(QAFWebElement loginLoader) {
	this.loginLoader = loginLoader;
}

public boolean equals(Object obj)
{
	if(null!=obj && obj instanceof String)
	{
	return lnkForSidebar.getText().equalsIgnoreCase((String)obj);
	}
	return super.equals(obj);
	}
}
