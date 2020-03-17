package jackyy.exchangers.integration;

import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.ObjectHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

public class ImmersiveEngineeringIntegration {

    public static ItemStack lvCapacitor;
    public static ItemStack mvCapacitor;
    public static ItemStack hvCapacitor;
    public static ItemStack lvWireCoil;
    public static ItemStack mvWireCoil;
    public static ItemStack hvWireCoil;
    public static ItemStack ironMechanicalComponent;
    public static ItemStack steelMechanicalComponent;
    public static ItemStack heavyEngineeringBlock;
    public static ItemStack bucketCreosote;
    public static ItemStack bucketPlantOil;
    public static ItemStack bucketBiodiesel;

    public static void init() {
        Reference.LOGGER.info("Fetching items for Immersive Engineering integration...");

        Block capBlock = ObjectHelper.getBlockByName(Reference.IE, "metal_device0");
        lvCapacitor = new ItemStack(capBlock, 1, 0);
        mvCapacitor = new ItemStack(capBlock, 1, 1);
        hvCapacitor = new ItemStack(capBlock, 1, 2);

        Block engBlock = ObjectHelper.getBlockByName(Reference.IE, "metal_decoration0");
        heavyEngineeringBlock = new ItemStack(engBlock, 1, 5);

        Item wireCoil = ObjectHelper.getItemByName(Reference.IE, "wirecoil");
        if (wireCoil != null) {
            lvWireCoil = new ItemStack(wireCoil, 1, 0);
            mvWireCoil = new ItemStack(wireCoil, 1, 1);
            hvWireCoil = new ItemStack(wireCoil, 1, 2);
        }

        Item material = ObjectHelper.getItemByName(Reference.IE, "material");
        if (material != null) {
            ironMechanicalComponent = new ItemStack(material, 1, 8);
            steelMechanicalComponent = new ItemStack(material, 1, 9);
        }

        Fluid creosote = FluidRegistry.getFluid("creosote");
        bucketCreosote = FluidUtil.getFilledBucket(new FluidStack(creosote, 1000));
        Fluid plantOil = FluidRegistry.getFluid("plantoil");
        bucketPlantOil = FluidUtil.getFilledBucket(new FluidStack(plantOil, 1000));
        Fluid biodiesel = FluidRegistry.getFluid("biodiesel");
        bucketBiodiesel = FluidUtil.getFilledBucket(new FluidStack(biodiesel, 1000));
    }

}
