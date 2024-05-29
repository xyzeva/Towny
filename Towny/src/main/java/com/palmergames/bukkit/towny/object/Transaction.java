package com.palmergames.bukkit.towny.object;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import com.palmergames.bukkit.towny.object.economy.Account;

public class Transaction {
	private final TransactionType type;
	private final Account receivingAccount;
	private final Account sendingAccount;
	private final double amount;
	
	public Transaction(TransactionType type, Account sendingAccount, Account receivingAccount, double amount) {
		this.type = type;
		this.sendingAccount = sendingAccount;
		this.receivingAccount = receivingAccount;
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public Account getReceivingAccount() {
		return receivingAccount;
	}

	public Account getSendingAccount() {
		return sendingAccount;
	}

	@Nullable
	public Player getPlayer() {
		return Bukkit.getServer().getPlayerExact(getSendingAccount().getName());
	}

	public double getAmount() {
		return amount;
	}
}
