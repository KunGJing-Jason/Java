package Interface;

public class Example6_7 {
    public static void main(String[] args){
        AdvertisementBoard board = new AdvertisementBoard();
        board.show();
        board.setAdvertisement(new BlackBoard());
        board.show();
        board.setAdvertisement(new WhiteCloud());
        board.show();
    }
}
