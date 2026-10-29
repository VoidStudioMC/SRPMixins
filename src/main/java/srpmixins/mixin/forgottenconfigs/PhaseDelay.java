package srpmixins.mixin.forgottenconfigs;

import com.dhanantry.scapeandrunparasites.util.config.SRPConfigSystems;
import com.dhanantry.scapeandrunparasites.world.SRPSaveData;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = SRPSaveData.class, remap = false)
public abstract class PhaseDelay {
    @Inject(method = "getDelay", at = @At("HEAD"), cancellable = true)
    private void srpmixins_useAllPhaseDelayConfigs(byte phase, CallbackInfoReturnable<Integer> cir) {
        switch (phase) {
            case 9: cir.setReturnValue(SRPConfigSystems.phaseDelayTicksNine); break;
            case 10: cir.setReturnValue(SRPConfigSystems.phaseDelayTicksTen); break;
        }
    }
}
