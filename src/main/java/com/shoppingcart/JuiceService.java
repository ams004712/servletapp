package com.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.model.JuiceType;

/**
 * Created by kasun on 5/24/17.
 */
public class JuiceService {

	public List getAvailableBrands(JuiceType type) {

		List brands = new ArrayList();

		if (type.equals(JuiceType.GRAPES)) {
			brands.add("Real");
			brands.add(("J. P. Chenet"));

		} else if (type.equals(JuiceType.LIMBO)) {
			brands.add("Glenfiddich");
			brands.add("Minute Maid");

		} else if (type.equals(JuiceType.ORANGE)) {
			brands.add("Real");

		} else {
			brands.add("No Brand Available");
		}
		return brands;
	}
}
