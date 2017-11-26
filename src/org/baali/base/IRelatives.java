package org.baali.base;

import java.util.List;
import java.util.Map;

public interface IRelatives
{
    void setCurrentGenerationRelatives(Map<String, List<IPerson>> relatives);

    Map<String, List<IPerson>> getCurrentGenerationRelatives();

}
