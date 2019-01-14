package com.qq4492040.top.Minecarft;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ItemJoinMsg extends JavaPlugin implements Listener {
    private static String ItemName;
    private static String ItemNameMsg;
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        File file = new File(getDataFolder(),"config.yml");
        if (!(file.exists())){
            saveDefaultConfig();
        }
        ItemName = getConfig().getString("ItemName");
        ItemNameMsg = getConfig().getString("ItemNameMsg");
        System.out.println("加载ItemJoinMsg成功..");
        System.out.println("淘宝店名:滴水魄罗科技");
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        super.onEnable();
    }

    @EventHandler
    public void PlayerJoinGame(PlayerJoinEvent event){
        Inventory inv = event.getPlayer().getInventory();
        for (int i =0;i<=8;i++){
            ItemStack itemStack = inv.getItem(i);
            if (itemStack!=null&&itemStack.getItemMeta()!=null){
                String ItemDisPlayName = itemStack.getItemMeta().getDisplayName();
                if (ItemDisPlayName.contains(ItemName)){
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"bc "+ItemNameMsg.replace("[PlayerName]",event.getPlayer().getName()).replace("[ItemName]",ItemDisPlayName));
                }
            }
        }
        for (int i =9;i<=35;i++){
            ItemStack itemStack = inv.getItem(i);
            if (itemStack!=null&&itemStack.getItemMeta()!=null){
                String ItemDisPlayName = itemStack.getItemMeta().getDisplayName();
                if (ItemDisPlayName.contains(ItemName)){
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"bc "+ItemNameMsg.replace("[PlayerName]",event.getPlayer().getName()).replace("[ItemName]",ItemDisPlayName));
                }
            }
        }
    }
}
