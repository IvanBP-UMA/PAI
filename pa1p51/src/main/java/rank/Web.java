package rank;

import java.util.*;
import java.util.stream.Collectors;

public class Web {
    protected Set<Site> sites;
    private Set<Link> links;
    private static final double THRESHOLD = 1E-5;
    private static Random alea = new Random(1);

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

    public void addLink(String dataLink){
        try{
            String[] siteNames = dataLink.split("->");
            addSiteWithName(siteNames[0]);
            addSiteWithName(siteNames[1]);
            links.add(new Link(siteNames[0], siteNames[1]));
        }catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException(dataLink);
        }
    }

    public Site getSite(String name){
        Site search = new Site(name);
        if (!sites.contains(search)){
            throw new NoSuchElementException(name);
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

    protected void distribute(Site site, double prize){
        if (prize>=THRESHOLD){
            site.addRank(prize/2);

            Set<Site> linkedSites = getSitesLinkedFrom(site);
            Iterator<Site> iterator = linkedSites.iterator();
            while (iterator.hasNext()){
                distribute(iterator.next(), prize/(2*linkedSites.size()));
            }
        }
    }

    public void click(String name){
        try{
            Site site = getSite(name);
            distribute(site, 1);
        }catch (NoSuchElementException ignored){}
    }

    public void simulateClick(int numClick){
        if (!sites.isEmpty()) {
            List<Site> sitesList = sites.stream().toList();
            for (int i = 0; i < numClick; i++) {
                click(sitesList.get(alea.nextInt(sites.size())).getName());
            }
        }
    }

    public SortedSet<Site> getSitesByName(){
        return new TreeSet<Site>(sites);
    }

    public SortedSet<Site> getSitesByRank(){
        Comparator<Site> comparator = new RankOrder();
        SortedSet<Site> siteSortedSet = new TreeSet<>(comparator);
        siteSortedSet.addAll(sites);
        return siteSortedSet;
    }

    @Override
    public String toString() {
        String res = "Web(";
        res += sites.toString()+", "+ links.toString()+")";
        return res;
    }
}
