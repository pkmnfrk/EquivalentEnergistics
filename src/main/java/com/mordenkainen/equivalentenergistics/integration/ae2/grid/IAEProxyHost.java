package com.mordenkainen.equivalentenergistics.integration.ae2.grid;

import appeng.api.implementations.IPowerChannelState;
import appeng.api.networking.IGridHost;
import appeng.api.networking.IGridNode;
import appeng.api.networking.security.IActionHost;
import appeng.api.util.AECableType;
import appeng.api.util.AEPartLocation;
import appeng.api.util.DimensionalCoord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public interface IAEProxyHost extends IGridHost, IActionHost, IPowerChannelState {

    @Override
    default IGridNode getGridNode(final AEPartLocation arg0) {
        return getProxy().getNode();
    }

    @Override
    default AECableType getCableConnectionType(final AEPartLocation arg0) {
        return AECableType.SMART;
    }

    @Override
    default IGridNode getActionableNode() {
        return getProxy().getNode();
    }

    default void setOwner(final EntityPlayer player) {
        getProxy().setOwner(player);
    }

    default void onChunkUnload() {
        getProxy().onChunkUnload();
    }

    default void invalidate() {
        getProxy().invalidate();
    }

    default void validate() {
        getProxy().validate();
    }

    default void onReady() {
        getProxy().onReady();
    }

    default void readFromNBT(final NBTTagCompound data) {
        getProxy().readFromNBT(data);
    }

    default NBTTagCompound writeToNBT(final NBTTagCompound data) {
        getProxy().writeToNBT(data);
        return data;
    }

    default void gridChanged() {}

    AEProxy getProxy();

    DimensionalCoord getLocation();


}
