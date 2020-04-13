package dev.j3fftw.litexpansion.resources;

import dev.j3fftw.litexpansion.Items;
import dev.j3fftw.litexpansion.LiteXpansion;
import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class MagThorResource implements GEOResource {

    private final NamespacedKey key = new NamespacedKey(LiteXpansion.getInstance(), "magthor");
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final boolean obtainableFromGEOMiner;

    public MagThorResource(boolean obtainableFromGEOMiner) {
        this.obtainableFromGEOMiner = obtainableFromGEOMiner;
    }

    @Override
    public int getDefaultSupply(World.Environment environment, Biome biome) {
        switch (biome) {
            case MOUNTAINS:
            case GRAVELLY_MOUNTAINS:
            case WOODED_MOUNTAINS:
            case SNOWY_MOUNTAINS:
            case MODIFIED_GRAVELLY_MOUNTAINS:
                return random.nextInt(3) + 1;
            default:
                return 1;
        }
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @Override
    public int getMaxDeviation() {
        return 6;
    }

    @Override
    public String getName() {
        return "Mag-Thor";
    }

    @Override
    public ItemStack getItem() {
        return Items.MAG_THOR.clone();
    }

    @Override
    public boolean isObtainableFromGEOMiner() {
        return obtainableFromGEOMiner;
    }


}
