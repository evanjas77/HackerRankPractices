package com.hackerrank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MarkZoidBotTest {

	public static void main(String[] args) {

		// Sample Input
		// 0 0
		// b---d
		// -d--d
		// --dd-
		// --d--
		// ----d
		Scanner in = new Scanner(System.in);
		MarkZoidBot mzBot = new MarkZoidBot();
		mzBot.setX(in.nextInt());
		mzBot.setY(in.nextInt());
		List<DirtyCell> dirtyCellList = new ArrayList<DirtyCell>();

		String dirtyCellX = null;
		int rowCount = 0;
		while (rowCount < 5) {
			dirtyCellX = in.next();
			String[] dirtyCellsY = dirtyCellX.split("");

			for (int i = 0; i < dirtyCellsY.length; i++) {
				if (dirtyCellsY[i].equalsIgnoreCase("d")) {
					DirtyCell dc = new DirtyCell(rowCount, i);
					dirtyCellList.add(dc);
				}
			}
			rowCount++;
		}
		Collections.sort(dirtyCellList, new Comparator<DirtyCell>() {

			@Override
			public int compare(DirtyCell o1, DirtyCell o2) {
				return o1.getDistanceFromBot(mzBot).compareTo(o2.getDistanceFromBot(mzBot));
			}
		});

		System.out.println(mzBot.nextMove(dirtyCellList));
	}

}

class MarkZoidBot {

	private int mX;
	private int mY;

	public void setX(int x) {
		this.mX = x;

	}

	public void setY(int y) {
		this.mY = y;

	}

	public int getmX() {
		return mX;
	}

	public void setmX(int mX) {
		this.mX = mX;
	}

	public int getmY() {
		return mY;
	}

	public void setmY(int mY) {
		this.mY = mY;
	}

	public String nextMove(List<DirtyCell> dirtyCellList) {

		// Pick the first dirty cell which happens to be the nearest from bot
		DirtyCell dc = dirtyCellList.get(0);
		// Compute the X and Y distance from Bot and move

		if (dc != null) {
			Integer xAxisDist = dc.getXDistanceFromBot(this);
			Integer yAxisDist = dc.getYDistanceFromBot(this);

			// Move RIGHT, DOWN, CLEAN
			if (yAxisDist > 0)
				return "RIGHT";
			else if (xAxisDist > 0)
				return "DOWN";
			else if (yAxisDist < 0)
				return "LEFT";
			else if (xAxisDist < 0)
				return "UP";
		}
		return "CLEAN";
	}
}

class DirtyCell {
	private int mX;
	private int mY;

	public DirtyCell(int x, int y) {
		this.mX = x;
		this.mY = y;
	}

	public int getmX() {
		return mX;
	}

	public void setmX(int x) {
		this.mX = x;
	}

	public int getmY() {
		return mY;
	}

	public void setmY(int y) {
		this.mY = y;
	}

	public Double getDistanceFromBot(MarkZoidBot bot) {

		// Formula square root of ((bx-dx) power 2 + (by-dy) power 2)
		Double bXdXPow2 = Math.pow((bot.getmX() - getmX()), 2);
		Double bYdYPow2 = Math.pow((bot.getmY() - getmY()), 2);
		return Math.sqrt(bXdXPow2 + bYdYPow2);
	}

	public Integer getXDistanceFromBot(MarkZoidBot bot) {
		return getmX() - bot.getmX();
	}

	public Integer getYDistanceFromBot(MarkZoidBot bot) {
		return getmY() - bot.getmY();

	}

}
