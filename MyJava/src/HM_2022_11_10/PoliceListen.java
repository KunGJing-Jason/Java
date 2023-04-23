package HM_2022_11_10;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PoliceListen implements ActionListener{
    WindowInput output;

    public void setInput(WindowInput output) {
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double sum = 0.00;
        if(e.getSource() == output.InputText){
            String str[] = output.InputText.getText().split(" ");

            for (int i =0 ; i < str.length; i++){
                sum += Double.parseDouble(str[i]);
            }
            double avg = sum / str.length;
            output.OutputText.append("总和为："+ sum +", "+" 平均数为："+ avg + "\n");
            sum = 0.00;
        }
    }
}
