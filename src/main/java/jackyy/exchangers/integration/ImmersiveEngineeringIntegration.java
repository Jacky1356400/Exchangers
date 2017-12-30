package jackyy.exchangers.integration;

import jackyy.exchangers.Exchangers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.UniversalBucket;

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
        Exchangers.logger.info("Fetching items for Immersive Engineering integration...");

        Block capBlock = Block.REGISTRY.getObject(new ResourceLocation(Exchangers.IE, "metalDevice0"));
        lvCapacitor = new ItemStack(capBlock, 1, 0);
        mvCapacitor = new ItemStack(capBlock, 1, 1);
        hvCapacitor = new ItemStack(capBlock, 1, 2);

        Block engBlock = Block.REGISTRY.getObject(new ResourceLocation(Exchangers.IE, "metalDecoration0"));
        heavyEngineeringBlock = new ItemStack(engBlock, 1, 5);

        Item wireCoil = Item.REGISTRY.getObject(new ResourceLocation(Exchangers.IE, "wirecoil"));
        if (wireCoil != null) {
            lvWireCoil = new ItemStack(wireCoil, 1, 0);
            mvWireCoil = new ItemStack(wireCoil, 1, 1);
            hvWireCoil = new ItemStack(wireCoil, 1, 2);
        }

        Item material = Item.REGISTRY.getObject(new ResourceLocation(Exchangers.IE, "material"));
        if (material != null) {
            ironMechanicalComponent = new ItemStack(material, 1, 8);
            steelMechanicalComponent = new ItemStack(material, 1, 9);
        }

        Fluid creosote = FluidRegistry.getFluid("creosote");
        bucketCreosote = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, creosote);
        Fluid plantOil = FluidRegistry.getFluid("plantoil");
        bucketPlantOil = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, plantOil);
        Fluid biodiesel = FluidRegistry.getFluid("biodiesel");
        bucketBiodiesel = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, biodiesel);
    }

}
