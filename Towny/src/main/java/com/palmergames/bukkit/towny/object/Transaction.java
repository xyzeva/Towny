package com.palmergames.bukkit.towny.object;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import com.palmergames.bukkit.towny.object.economy.Account;

public class Transaction {
	private final TransactionType type;
	private final Account account;
	private final double amount;
	
	public Transaction(TransactionType type, Account account, double amount) {
		this.type = type;
		this.account = account;
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public String getName() {
		return account.getName();
	}

	/**
	 * @return the TownyObject, ie Town, Nation, Resident behind this Transaction's
	 *         Account, or null if it involves the
	 *         {@link EconomyAccount#SERVER_ACCOUNT}.
	 */
	@Nullable
	public TownyObject getTownyObject() {
		return account.getTownyObject();
	}

	@Nullable
	public Player getPlayer() {
		return Bukkit.getServer().getPlayerExact(getName());
	}

	public double getAmount() {
		return amount;
	}
}
