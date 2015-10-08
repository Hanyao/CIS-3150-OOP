package PC;
import EleDevice.EleDevice;

public class PC extends EleDevice{
	private int totalspace;
	private int freespace;
	private String brand;
	private int battery;
	private static boolean onoff = false;

	public PC(){
		this(0, 0, "", 0);
	}

	public PC(int v, int ts, String br, int ba){
		super(v);
		this.totalspace = ts;
		this.brand = br;
		this.battery = ba;
		this.freespace = this.totalspace;
	}

	public static void switchOnOff(){
		if (onoff){
			onoff = false;
		} else {
			onoff = true;
		}
	}
	public int getVolt(){
		int v = super.volt;
		return v;
	}
}