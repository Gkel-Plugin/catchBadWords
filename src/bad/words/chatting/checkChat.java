package bad.words.chatting;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation") 
public class checkChat implements Listener{
	public ArrayList<String> cbd = new ArrayList<>();
	@EventHandler
	public void onPlayerChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		for(String w : cbd) {
			if(e.getMessage().toLowerCase().contains(w)) {
				e.setCancelled(true);
				p.sendMessage(ChatColor.RED+"비속어는 사용하실 수 없습니다");
			}
		}
	}
	
}
