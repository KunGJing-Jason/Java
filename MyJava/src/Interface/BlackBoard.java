package Interface;

public class BlackBoard implements Advertisement{
    @Override
    public void ShowAdvertiseMent() {
        System.out.println("**************************");
        System.out.println("Work is the fater\n Ground is the mother\n");
        System.out.println("**************************");
    }

    @Override
    public String getCorpName() {
        return "BlackLand Corporation";
    }
}
