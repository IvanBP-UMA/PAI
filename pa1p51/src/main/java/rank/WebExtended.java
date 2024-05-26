package rank;

public class WebExtended extends Web{

    @Override
    protected void addSiteWithName(String name) {
        SiteExtended site = new SiteExtended(name);
        addSite(site);
    }

    @Override
    protected void distribute(Site site, double prize) {
        SiteExtended siteExtended = (SiteExtended) site;
        if(siteExtended.isValid()) {
            super.distribute(site, prize);
        }
    }

    public void switchSiteWithName(String name){
        SiteExtended site = (SiteExtended) getSite(name);
        site.setValid(!site.isValid());
    }
}
