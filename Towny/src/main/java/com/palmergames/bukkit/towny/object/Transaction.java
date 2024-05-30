package com.palmergames.bukkit.towny.object;

import org.bukkit.entity.Player;


/**
 * @deprecated since 0.100.3.1 use {@link com.palmergames.bukkit.towny.object.economy.transaction.Transaction} instead.
 */
@Deprecated
public class Transaction {
	private final TransactionType type;
	private final Player player;
	private final double amount;
	
	public Transaction(TransactionType type, Player player, double amount) {
		this.type = type;
		this.player = player;
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public Player getPlayer() {
		return player;
	}

	public double getAmount() {
		return amount;
	}
}
