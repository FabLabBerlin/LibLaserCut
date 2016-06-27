/**
 * This file is part of LibLaserCut.
 * Copyright (C) 2011 - 2014 Thomas Oster <mail@thomas-oster.de>
 *
 * LibLaserCut is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LibLaserCut is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with LibLaserCut. If not, see <http://www.gnu.org/licenses/>.
 *
 **/
package com.t_oster.liblasercut.drivers;

import com.t_oster.liblasercut.FloatPowerSpeedFocusFrequencyProperty;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Thomas Oster <thomas.oster@rwth-aachen.de>
 */
public class TrotecCutterProperty extends FloatPowerSpeedFocusFrequencyProperty {
  
  private boolean hidePurge = false;
  private boolean hideVentilation = false;
  private boolean hideFocus = false;
  private boolean hideFrequency = false;
    
  //private boolean ventilation = true;
  private int frequency = 6000;

  public TrotecCutterProperty(boolean hideFrequency)
  {
    this.hideFrequency = hideFrequency;
  }
  
  public TrotecCutterProperty()
  {
    this(false);
  }
  
    /** Set the frequency */
  public void setFrequency(int freq)
  {
    this.frequency = freq;
  }
  
  public int getFrequency()
  {
    return this.frequency;
  }
  
  /**
   * Get the value of ventilation
   *
   * @return the value of ventilation
   */
  /*
  public boolean getVentilation()
  {
    return ventilation;
  }
  */
  

  /**
   * Set the value of ventilation
   *
   * @param ventilation new value of ventilation
   */
  /*
  public void setVentilation(boolean ventilation)
  {
    this.ventilation = ventilation;
  }
*/
 
  @Override
  public String[] getPropertyKeys()
  {
    LinkedList<String> result = new LinkedList<String>();
    result.addAll(Arrays.asList(super.getPropertyKeys()));
    if (this.hideFocus)
    {
      result.remove("focus");
    }
    if (this.hideFrequency)
    {
      result.remove("frequency");
    }
    /*
    if (!this.hideVentilation)
    {
      result.add("ventilation");
    }
*/
  
    
    return result.toArray(new String[0]);
  }

  @Override
  public Object getProperty(String name)
  { /*
    if ("ventilation".equals(name))
    {
      return (Boolean) this.getVentilation();
    }
    */
    if ("frequency".equals(name))
    {
      return (int) this.getFrequency();
    }
    else
    {
      return super.getProperty(name);
    }
  }

  @Override
  public void setProperty(String name, Object value)
  {
    /* if ("ventilation".equals(name))
    {
      this.setVentilation((Boolean) value);
    } */
    if ("frequency".equals(name))
    {
      this.frequency = ((Integer) value);
    }
    else 
    {
      super.setProperty(name, value);
    }
  }

  @Override
  public TrotecCutterProperty clone()
  {
    TrotecCutterProperty result = new TrotecCutterProperty();
    for (String s:this.getPropertyKeys())
    {
      result.setProperty(s, this.getProperty(s));
    }
    return result;
  }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TrotecCutterProperty other = (TrotecCutterProperty) obj;
        /*if (this.ventilation != other.ventilation) {
            return false;
        } 
*/
        return super.equals(other);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        /*hash = 97 * hash + (this.ventilation ? 1 : 0);*/
        hash = 97 * hash + (this.frequency);
        hash = 97 * hash + super.hashCode();
        return hash;
    }
  
  
}
