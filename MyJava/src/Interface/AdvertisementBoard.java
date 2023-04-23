package Interface;

public class AdvertisementBoard {
    Advertisement advertisement;
    public void setAdvertisement(Advertisement advertisement){
        this.advertisement = advertisement;
    }

    public void show(){
        if(advertisement == null){
            System.out.println("Look for sponsor");
        }else{
            advertisement.ShowAdvertiseMent();
        }
    }
}
