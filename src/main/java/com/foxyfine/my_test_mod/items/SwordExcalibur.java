package com.foxyfine.my_test_mod.items;

import com.foxyfine.my_test_mod.TestMod;
import net.minecraft.item.SwordItem;

public class SwordExcalibur extends SwordItem {

    public SwordExcalibur() {
        super(SwordExcaliburSpecification.MAGIC_TIER, 8, 1, new Properties().stacksTo(1).tab(TestMod.MYMOD));

    }
}
