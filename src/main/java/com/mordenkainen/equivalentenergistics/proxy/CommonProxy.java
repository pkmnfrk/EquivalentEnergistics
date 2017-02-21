package com.mordenkainen.equivalentenergistics.proxy;

import com.mordenkainen.equivalentenergistics.crafting.CraftingManager;
import com.mordenkainen.equivalentenergistics.exception.ServerUnmetDependencyException;
import com.mordenkainen.equivalentenergistics.integration.Integration;
import com.mordenkainen.equivalentenergistics.lib.Reference;
import com.mordenkainen.equivalentenergistics.registries.BlockEnum;
import com.mordenkainen.equivalentenergistics.registries.ItemEnum;
import com.mordenkainen.equivalentenergistics.tiles.TileEMCCrafter;
import com.mordenkainen.equivalentenergistics.tiles.condenser.TileEMCCondenser;
import com.mordenkainen.equivalentenergistics.tiles.condenser.TileEMCCondenserAdv;
import com.mordenkainen.equivalentenergistics.tiles.condenser.TileEMCCondenserExt;
import com.mordenkainen.equivalentenergistics.tiles.condenser.TileEMCCondenserUlt;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

    public int crafterRenderer;

    public void preInit() {
        Integration.preInit();
        BlockEnum.registerBlocks();
    }

    public void init() {
        if (!Integration.Mods.PROJECTE.isEnabled() && !Integration.Mods.EE3.isEnabled()) {
            unmetDependency();
        }
        Integration.init();
        registerTileEntities();
        ItemEnum.registerItems();
        initRenderers();
        CraftingManager.initRecipes();
    }

    public void postInit() {
        Integration.postInit();
    }

    public boolean isClient() {
        return false;
    }

    public boolean isServer() {
        return true;
    }

    public void registerTileEntities() {
        if (BlockEnum.EMCCONDENSER.isEnabled()) {
            GameRegistry.registerTileEntity(TileEMCCondenser.class, Reference.MOD_ID + "TileEMCCondenser");
            GameRegistry.registerTileEntity(TileEMCCondenserAdv.class, Reference.MOD_ID + "TileEMCCondenserAdv");
            GameRegistry.registerTileEntity(TileEMCCondenserExt.class, Reference.MOD_ID + "TileEMCCondenserExt");
            GameRegistry.registerTileEntity(TileEMCCondenserUlt.class, Reference.MOD_ID + "TileEMCCondenserUlt");
        }
        if (BlockEnum.EMCCRAFTER.isEnabled()) {
            GameRegistry.registerTileEntity(TileEMCCrafter.class, Reference.MOD_ID + "TileEMCCrafter");
        }
    }

    public void initRenderers() {}

    public void unmetDependency() {
        throw new ServerUnmetDependencyException("Equivalent Energistics requires either Equivalent Exchange 3 or ProjectE to be installed and enabled!");
    }

}
