package com.daifukuamerica.wrxj.dbadapter.data;

import static com.daifukuamerica.wrxj.dbadapter.data.AlertEnum.*;

import com.daifukuamerica.wrxj.dbadapter.AbstractSKDCData;
import com.daifukuamerica.wrxj.dbadapter.TableEnum;
import com.daifukuamerica.wrxj.jdbc.AmountFullTransMapper;
import com.daifukuamerica.wrxj.jdbc.ColumnObject;
import com.daifukuamerica.wrxj.util.SKDCConstants;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:<BR>
 *   Title:  Class to handle LoadData Object.
 *   Description : Handles all data for load
 * @author       REA
 * @author       A.D.  Converted to use ColumnObjects for building SQL.
 * @version      1.0
 * @since       04-Jan-02
 */
public class AlertData extends AbstractSKDCData
{
  public static final String DEFAULT_POSITION_VALUE = "000";
  
  public static final String ALERTID_NAME         = ALERTID.getName();
  public static final String TIMESTAMP_NAME       = TIMESTAMP.getName();
  public static final String EVENTCODE_NAME       = EVENTCODE.getName();
  public static final String DESCRIPTION_NAME     = DESCRIPTION.getName();
  public static final String ACTIVEFLAG_NAME      = ACTIVEFLAG.getName();
  

// -------------------Alert Table data -----------------------------
  

  private String sAlertId           = "";
  private Date dTimeStamp			= new Date();
  private String iEventCode         = "";
  private String description     	= "";
  private String iActiveFlag        = "";
 
  private static final Map<String, TableEnum> mpColumnMap = new ConcurrentHashMap<String, TableEnum>();
  private static Map<String, AmountFullTransMapper> mpPartialQtyMap;

  public AlertData()
  {
    sdf.applyPattern(SKDCConstants.DateFormatString);
    clear();
    initColumnMap(mpColumnMap, AlertEnum.class);
  }

  @Override
  public void clear()
  {
    super.clear();
    sAlertId           	= "";
    dTimeStamp			= new Date();
    iEventCode         	= "";
    description     	= "";
    iActiveFlag        	= "";
  }




  @Override
	public String toString() {
		return "AlertData [sAlertId=" + sAlertId + ", dTimeStamp=" + dTimeStamp + ", iEventCode=" + iEventCode
				+ ", description=" + description + ", iActiveFlag=" + iActiveFlag + "]";
	}

/**
   *  Method to perform clone of <code>LoadData</code>.
   *
   *  @return copy of <code>LoadData</code>
   */
  @Override
  public AlertData clone()
  {
    AlertData vpClonedData = (AlertData)super.clone();
    return vpClonedData;
  }

  @Override
  public boolean equals(AbstractSKDCData absLD)
  {
//    AlertData ld = (AlertData)absLD;
//    return(ld.getLoadID().equals(this.getLoadID()));
	  return false;
  }

/*---------------------------------------------------------------------------
                              Set Methods.
  ---------------------------------------------------------------------------*/
  
  
  public void setAlertId(String sAlertId)
  {
	sAlertId = checkForNull(sAlertId);
    addColumnObject(new ColumnObject(ALERTID_NAME, sAlertId));
  }

  public void setTimeStamp(Date ipColValue)
  {
    addColumnObject(new ColumnObject(TIMESTAMP_NAME, ipColValue));
  }

  public void setEventCode(String iEventCode)
  {
	  iEventCode = checkForNull(iEventCode);
    addColumnObject(new ColumnObject(EVENTCODE_NAME, iEventCode));
  }

  public void setDescription(String description)
  {
	  description = checkForNull(description);
    addColumnObject(new ColumnObject(DESCRIPTION_NAME, description));
  }
  
  public void setActiveFlag(String iActiveFlag)
  {
	  iActiveFlag = checkForNull(iActiveFlag);
    addColumnObject(new ColumnObject(ACTIVEFLAG_NAME, iActiveFlag));
  }

/*---------------------------------------------------------------------------
                              Get Methods.
  ---------------------------------------------------------------------------*/
  public String getAlertId()
  {
    return sAlertId;
  }
  
  public Date getTimeStamp()
  {
    return dTimeStamp;
  }

  public String getEventCode()
  {
    return iEventCode;
  }

  public String getDescription()
  {
    return description;
  }

  public String getActiveFlag()
  {
    return iActiveFlag;
  }


/**
   * {@inheritDoc}
   * @param {@inheritDoc}
   * @param {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public int setField(String isColName, Object ipColValue)
  {
    TableEnum vpEnum = mpColumnMap.get(isColName);
    if (vpEnum == null)
    {
      return super.setField(isColName, ipColValue);
    }

    switch((AlertEnum)vpEnum)
    {
    
      case ALERTID:
        setAlertId((String)ipColValue);
        break;

      case TIMESTAMP:
        setTimeStamp((Date)ipColValue);
        break;

      case EVENTCODE:
        setEventCode((String)ipColValue);
        break;
        
      case DESCRIPTION:
        setDescription((String)ipColValue);
        break;

      case ACTIVEFLAG:
        setActiveFlag((String)ipColValue);
        break;
    }

    return(0);
  }


 /**
  * Method to get a map of decimal representations of amount full translation values.
  * @return Map of amount full Translation strings to double quantities.
  */
  public static Map<String, AmountFullTransMapper> getAmountFullDecimalMap()
  {
    return(mpPartialQtyMap);
  }
  
}
