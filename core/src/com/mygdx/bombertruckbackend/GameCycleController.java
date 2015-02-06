package com.mygdx.bombertruckbackend;

import java.util.HashMap;
import java.util.Iterator;

import com.mygdx.bombertruckbackend.Player;
import com.mygdx.bombertruckbackend.MapObject;
import com.mygdx.bombertruckbackend.Map;
import com.mygdx.bombertruckbackend.PlayerController;

public class GameCycleController {
	private Map mapObj = null;
	private HashMap<String, PlayerController> loggedPlayerControllerHashMap = new HashMap<String, PlayerController>();
	
	public GameCycleController (Map map) {
		this.mapObj = map;
	}
	
	public void onCycle() {
		for (int x = 0; x < mapObj.getMapSizeX(); x++) {
			for (int y = 0; y < mapObj.getMapSizeY(); y++) {
				this.mapObj.getLocation(x, y).getMapObject().onRefresh();
			}
		}
		
		for (int x = 0; x < mapObj.getMapSizeX(); x++) {
			for (int y = 0; y < mapObj.getMapSizeY(); y++) {
				if (!(this.mapObj.getLocation(x, y).getMapObject().isMoved())) {
					this.mapObj.getLocation(x, y).getMapObject().onCycle();
				}
			
			}
		}
		
		//cycle all player commands
		
		Iterator<String> allCommandQueueKeyIterator = loggedPlayerControllerHashMap.keySet().iterator();
		while (allCommandQueueKeyIterator.hasNext()) {
			loggedPlayerControllerHashMap.get(allCommandQueueKeyIterator.next()).executeCommand();	
		}
		
	}
	
	public boolean playerLogin(String playerID) {
		
		boolean result = false;
		
		if (loggedPlayerControllerHashMap.containsKey(playerID)) {
			return false;
		}
		
		for (int x = 0; x < mapObj.getMapSizeX(); x++) {
			for (int y = 0; y < mapObj.getMapSizeY(); y++) {
				MapObject mapObjectObj = this.mapObj.getLocation(x, y).getMapObject();
				if (mapObjectObj instanceof Player) {
					result = ((Player)mapObjectObj).setPlayerID(playerID);
					if (result) {
						loggedPlayerControllerHashMap.put(playerID, new PlayerController((Player)mapObjectObj));
					}
				}
			}
		}
		return result;
	}
	
	
	public PlayerController testControlPlayerOne() {
		playerLogin("1");
		return loggedPlayerControllerHashMap.get("1");
	}
	
	public Map sentMap() {
		return this.mapObj;
	}
}
