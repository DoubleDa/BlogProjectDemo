package com.dyx.bpls;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dyx.bpls.base.BaseActivity;
import com.dyx.bpls.util.ValidUtils;
import com.dyx.bpls.widget.EditTextWithDelete;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    @Bind(R.id.et_username)
    EditTextWithDelete etUsername;
    @Bind(R.id.et_password)
    EditTextWithDelete etPassword;
    @Bind(R.id.btn_show_pw)
    Button btnShowPw;
    @Bind(R.id.btn_comfirm)
    Button btnComfirm;
    @Bind(R.id.tv_login)
    TextView tvLogin;
    @Bind(R.id.pb)
    ProgressBar pb;
    @Bind(R.id.rl_login)
    RelativeLayout rlLogin;

    private boolean isHidden = true;

    private boolean isUsernameEt = false;
    private boolean isPasswordEt = false;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        //TODO http://www.open-open.com/code/view/1437356601662
    }

    private void initView() {
        pb.setVisibility(View.INVISIBLE);
        btnComfirm.setEnabled(false);
        /**
         * 用户名
         */
        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String result = etUsername.getText().toString().trim();
                if (!result.equals("")) {
                    if (ValidUtils.isUserName(result)) {
                        isUsernameEt = true;
                        showSnackBarLoc(btnComfirm, getString(R.string.username_valid));
                    } else {
                        isUsernameEt = false;
                        showSnackBarLoc(btnComfirm, getString(R.string.username_invalid));
                    }
                } else {
                    isUsernameEt = false;
                }
                handleBtnEnable();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        /**
         * 密码
         */
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String result = etPassword.getText().toString().trim();
                if (!result.equals("")) {
                    if (ValidUtils.isPassword(result)) {
                        isPasswordEt = true;
                        showSnackBarLoc(btnComfirm, getString(R.string.password_valid));
                    } else {
                        isPasswordEt = false;
                        showSnackBarLoc(btnComfirm, getString(R.string.password_invalid));
                    }
                } else {
                    isPasswordEt = false;
                }
                handleBtnEnable();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                boolean isValidKey = keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER;
                boolean isValidAction = actionId == EditorInfo.IME_ACTION_DONE;

                if (isValidKey || isValidAction) {
                    // do login request
                }
                return false;
            }
        });
    }

    private void handleBtnEnable() {
        if (isUsernameEt && isPasswordEt) {
            btnComfirm.setEnabled(true);
        } else {
            btnComfirm.setEnabled(false);
        }
    }


    @OnClick({R.id.btn_show_pw, R.id.btn_comfirm, R.id.rl_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_pw:
                if (isHidden) {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                isHidden = !isHidden;
                etPassword.postInvalidate();
                break;
            case R.id.btn_comfirm:
                final String username = etUsername.getText().toString().trim();
                final String password = etPassword.getText().toString().trim();
                if (isNetworkOn(this)) {
                    dialog = new ProgressDialog(LoginActivity.this);
                    dialog.show();
                    /**
                     * 模拟网络请求
                     */
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3000);
                                dialog.dismiss();
                                handleLogin(username, password);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                } else {
                    showSnackbar(btnComfirm, getString(R.string.net_off));
                }
                break;
            case R.id.rl_login:
                tvLogin.setVisibility(View.INVISIBLE);
                pb.setVisibility(View.VISIBLE);
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            intentTo(MainActivity.class);
                            finish();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                break;
            default:
                break;
        }
    }

    private void handleLogin(String username, String password) {
        if (username.equals("dayongxin") && password.equals("qwer1234")) {
            intentTo(MainActivity.class);
            finish();
        } else {
            showSnackbar(btnComfirm, getString(R.string.login_error));
        }
    }
}
