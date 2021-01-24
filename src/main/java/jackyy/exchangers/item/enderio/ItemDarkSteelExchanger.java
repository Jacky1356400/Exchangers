package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemDarkSteelExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.darkSteelMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.darkSteelPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.darkSteelMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.darkSteelMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.darkSteelMaxEnergy;
            perBlockUse = DefaultValues.darkSteelPerBlockUse;
            harvestLevel = DefaultValues.darkSteelMaxHarvestLevel;
            range = DefaultValues.darkSteelMaxRange;
            loaded = DefaultValues.enderIOModule;
        }
    }

    public ItemDarkSteelExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "dark_steel_exchanger");
    }

    @Override
    public int getMaxEnergy() {
        return energy;
    }

    @Override
    public int getPerBlockUse() {
        return perBlockUse;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getMaxRange() {
        return range;
    }

    @Override
    public int getTier() {
        return 5;
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.EIO);
    }

}
