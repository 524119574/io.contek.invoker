package io.contek.invoker.hbdmlinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;

@NotThreadSafe
public class _CrossAccountPositionInfo {

  public String margin_mode;
  public String margin_account;
  public String margin_asset;
  public double margin_balance;
  public double margin_static;
  public double margin_position;
  public double margin_frozen;
  public double profit_real;
  public double profit_unreal;
  public double withdraw_available;
  public double risk_rate;
  public List<_CrossPositionInfo> positions;
  public List<_CrossAccountContractDetail> contract_detail;
}
