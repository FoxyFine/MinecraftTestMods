package com.foxyfine.my_test_mod.init;

import com.foxyfine.my_test_mod.TestMod;
import com.foxyfine.my_test_mod.items.SwordExcalibur;
import com.foxyfine.my_test_mod.items.MaterialItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
public class ItemsRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);
    /*Хранятся все созданные нами предметы Первая переменная — это регистр для предметов.
    *Но он также регистр и для блоков, сущностей, структур. Всё зависит от указанного типа регистра.
    * DeferredRegister, что в переводе буквально ОтложенныйРегистр, будет отвечать за своевременную регистрацию всего, что мы ему укажем.
    * Очень удобный инструмент.*/
    public static final RegistryObject<Item> EXCALIBUR = ITEMS.register("excalibur", MaterialItem::new);
    /*Вторая переменная тут – сам предмет.
    *Вернее объект, который будет содержать все необходимые данные для создания нашего предмета при загрузке, а после содержать на него ссылку.*/
    public static final RegistryObject<Item> EXCALIBUR_SWORD = ITEMS.register("magic_sword", SwordExcalibur::new);
}
