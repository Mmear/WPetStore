package org.csu.wpetstore.persistence;

import org.csu.wpetstore.domain.Sequence;

/**
 * Created by WZF on 2018/4/30.
 */
public interface SequenceDAO {
    Sequence getSequence(Sequence sequence);
    void updateSequence(Sequence sequence);
}
