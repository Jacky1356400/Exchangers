package jacky.exchangers.item.thermalexpansion;

import java.util.List;

import jacky.exchangers.Config;
import jacky.exchangers.Exchangers;
import jacky.exchangers.helper.EnergyHelper;
import jacky.exchangers.helper.StringHelper;
import jacky.exchangers.item.ItemPoweredExchanger;
import jacky.exchangers.util.Data;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemResonantExchanger extends ItemPoweredExchanger {

	public ItemResonantExchanger() {
		setRegistryName(Data.MODID + ":resonant_exchanger");
		setUnlocalizedName(Data.MODID + ".resonant_exchanger");
		setMaxStackSize(1);
		setCreativeTab(Exchangers.exchangersCreativeTab);
		setNoRepair();
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return Config.resonantExchangerMaxRF;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		ItemStack empty = new ItemStack(this);
		list.add(empty);
		ItemStack full = new ItemStack(this);
		EnergyHelper.setDefaultEnergyTag(full, Config.resonantExchangerMaxRF);
		list.add(full);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
		super.addInformation(stack, world, tooltip, bool);
		tooltip.add(StringHelper.getTierText(3));
	}

}