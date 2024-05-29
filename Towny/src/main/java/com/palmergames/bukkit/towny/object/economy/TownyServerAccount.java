package com.palmergames.bukkit.towny.object.economy;

import java.util.UUID;

import org.bukkit.World;

import com.palmergames.bukkit.config.ConfigNodes;
import com.palmergames.bukkit.towny.TownyEconomyHandler;
import com.palmergames.bukkit.towny.TownySettings;
import com.palmergames.bukkit.towny.event.economy.TownyTransactionEvent;
import com.palmergames.bukkit.towny.object.EconomyHandler;
import com.palmergames.bukkit.towny.object.Transaction;
import com.palmergames.bukkit.towny.object.TransactionType;
import com.palmergames.bukkit.util.BukkitTools;

/**
 * For internal use only.
 */
public class TownyServerAccount extends Account implements EconomyHandler {
	
	private final static UUID uuid = UUID.fromString("a73f39b0-1b7c-4930-b4a3-ce101812d926");
	private final static String name = TownySettings.getString(ConfigNodes.ECO_CLOSED_ECONOMY_SERVER_ACCOUNT);

	public TownyServerAccount() {
		super(null, name);
	}

	@Override
	public Account getAccount() {
		return this;
	}

	public static UUID getUUID() {
		return uuid;
	}

	@Override
	protected synchronized boolean addMoney(double amount) {
		return TownyEconomyHandler.add(this, amount, world);
	}

	@Override
	protected synchronized boolean subtractMoney(double amount) {
		return TownyEconomyHandler.subtract(this, amount, world);
	}


	/**
	 * Adds money to the server account (used for towny closed economy.)
	 * 
	 * @param account Account sending money to the server. 
	 * @param amount The amount to deposit.
	 * @param world The world of the deposit.
	 * @return A boolean indicating success.
	 */
	public boolean addToServer(Account account, double amount, World world) {
		boolean success = TownyEconomyHandler.add(this, amount, world);;
		if (success)
			BukkitTools.fireEvent(new TownyTransactionEvent(new Transaction(TransactionType.ADD, account, Account.SERVER_ACCOUNT, amount)));

		return success;
	}

	/**
	 * Removes money to the server account (used for towny closed economy.)
	 *
	 * @param amount The amount to withdraw.
	 * @param world The world of the withdraw.
	 * @return A boolean indicating success.
	 */
	public boolean subtractFromServer(Account account, double amount, World world) {
		boolean success = TownyEconomyHandler.subtract(this, amount, world);
		if (success)
			BukkitTools.fireEvent(new TownyTransactionEvent(new Transaction(TransactionType.SUBTRACT, Account.SERVER_ACCOUNT, account, amount)));

		return success;
	}

}
