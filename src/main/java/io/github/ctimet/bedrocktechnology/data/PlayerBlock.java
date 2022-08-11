package io.github.ctimet.bedrocktechnology.data;

import java.io.Serializable;
import java.util.UUID;

public record PlayerBlock(UUID uuid, String id) implements Serializable {
}
