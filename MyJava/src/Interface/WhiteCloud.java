package Interface;

public class WhiteCloud implements Advertisement{
    @Override
    public void ShowAdvertiseMent() {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Fighter in airplanes");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
    }

    @Override
    public String getCorpName() {
        return "白云公司";
    }
}
