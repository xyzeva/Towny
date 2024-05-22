package com.palmergames.bukkit.towny.object;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class Transaction {
	private final TransactionType type;
	private final TownyObject townyObject;
	private final String name;
	private final double amount;
	
	public Transaction(TransactionType type, TownyObject townyObject, String name, double amount) {
		this.type = type;
		this.townyObject = townyObject;
		this.name = name;
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	@Nullable
	public TownyObject getTownyObject() {
		return townyObject;
	}

	public String getName() {
		return name;
	}

	@Nullable
	public Player getPlayer() {
		return Bukkit.getServer().getPlayerExact(name);
	}

	public double getAmount() {
		return amount;
	}
}
