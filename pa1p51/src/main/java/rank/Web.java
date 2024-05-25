package rank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Web {
    protected Set<Site> sites;
    private Set<Link> links;
    private double THRESHOLD;
    private Random alea;

    public Web(){
        sites = new HashSet<>();
        links = new HashSet<>();
    }

    protected void addSite(Site site){
        sites.add(site);
    }

    protected void addSiteWithName(String name){
        sites.add(new Site(name));
    }

    public void addLink(String dataLink) throws IllegalAccessException {
        try{
            String[] siteNames = dataLink.split("->");
            addSiteWithName(siteNames[0]);
            addSiteWithName(siteNames[1]);
            links.add(new Link(siteNames[0], siteNames[1]));
        }catch (IndexOutOfBoundsException e){
            throw new IllegalAccessException(dataLink);
        }
    }

    public Site getSite(String name){
        Site search = new Site(name);
        if (!sites.contains(search)){
            throw new NoSuchElementException(name);;
        }

        Iterator<Site> iterator = sites.iterator();
        boolean found = false;
        Site currentSite = null;

        while (iterator.hasNext() && !found){
            currentSite = iterator.next();
            if (search.equals(currentSite)){
                found = true;
            }
        }
        return currentSite;
    }

    public Set<String> getNames(){
        return sites.stream().map(Site::getName).collect(Collectors.toSet());
    }

    private Set<Site> getSitesLinkedFrom(Site pagina){
        Set<Site> linkedSites= links.stream()
                .filter(link -> pagina.equals(new Site(link.getOrigin())))
                .map(Link::getLinked)
                .map(Site::new)
                .collect(Collectors.toSet());
        return sites.stream().filter(linkedSites::contains).collect(Collectors.toSet());
    }
}
