package com.Ecommerce.Main.Global;

import java.util.ArrayList;
import java.util.List;

import com.Ecommerce.Main.Model.Product;

public class GlobalData {
	public static List<Product> cart;
	static {
		cart = new ArrayList<Product>();
	}
}
