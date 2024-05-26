package rank;

public class SiteExtended extends Site{
    private boolean valid;

    public SiteExtended(String nombre) {
        super(nombre);
        valid = true;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid(){
        return valid;
    }

    @Override
    public String toString() {
        return super.toString()+((valid)?"":"*");
    }
}
