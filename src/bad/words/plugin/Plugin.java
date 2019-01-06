package bad.words.plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import bad.words.chatting.checkChat;

public class Plugin extends JavaPlugin {
	checkChat cc = new checkChat();
	public String p = "plugins/CatchBadWords";
	public String u = "plugins/CatchBadWords/badwords.txt";
	File f = new File(u);
	File fp = new File(p);
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("[CatchBadWords] È°¼ºÈ­µÊ");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.cc, this);
		if(!(fp.exists())) {
			fp.mkdirs();
		}
		if (!(f.exists())) {
			writeFile(f);
		} else {
			readFile(f);
		}
	}

	public void onDisable() {
		getServer().getConsoleSender().sendMessage("[CatchBadWords] ºñÈ°¼ºÈ­µÊ");
	}
	
	public void readFile(File fi) {
		try {
			FileReader filereader = new FileReader(fi);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				cc.cbd.add(line);
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	public void writeFile(File fi) {
		String txt = "fxxk\r\nfuck\r\nfxxx\r\nwtf\r\n½Ã¹ß\r\n»õ³¢\r\nÁ¸³ª\r\nÁö¶ö\r\n¤µ¤²\r\n¤´\r\nº´½Å\r\n¤²¤µ";
		try {
			FileWriter fw = new FileWriter(fi, true);
			fw.write(txt);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
