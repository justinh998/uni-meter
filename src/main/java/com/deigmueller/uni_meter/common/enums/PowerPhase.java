package com.deigmueller.uni_meter.common.enums;
import org.jetbrains.annotations.NotNull;
import com.typesafe.config.Config;

public abstract class PowerPhase {
  public static final String PHASE_MODE_MONO = "mono-phase";
  public static final String PHASE_MODE_TRI = "tri-phase";
  public enum PhaseMode {
    MONO,
    TRI
  }
  public static PhaseMode getPhaseMode(@NotNull String key, @NotNull Config config) {
    String value = config.getString(key);

    if (PHASE_MODE_MONO.compareToIgnoreCase(value) == 0) {
      return PhaseMode.MONO;
    } else if (PHASE_MODE_TRI.compareToIgnoreCase(value) == 0) {
      return PhaseMode.TRI;
    } else {
      throw new IllegalArgumentException("unknown phase mode: " + value);
    }
  }
}
