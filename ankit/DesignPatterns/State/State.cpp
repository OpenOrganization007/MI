class CBaseState
{
public:
    // Pure virtual function
    virtual CBaseState* GetNextState() = 0;
    // print the string
    virtual    char* ToString() = 0;
};

//////////////////////////////////////////////////////////////////////////
// State Morning
//////////////////////////////////////////////////////////////////////////
class CMorning : public CBaseState
{
public:
    virtual CBaseState* GetNextState();
    virtual    char* ToString();
};

//////////////////////////////////////////////////////////////////////////
// State Evening
//////////////////////////////////////////////////////////////////////////
class CEvening : public CBaseState
{
public:
    virtual CBaseState* GetNextState();
    virtual    char* ToString();
};

//////////////////////////////////////////////////////////////////////////
// State night
//////////////////////////////////////////////////////////////////////////
class CNight: public CBaseState
{
public:
    virtual CBaseState* GetNextState();
    virtual    char* ToString();
};

//////////////////////////////////////////////////////////////////////////
// Context Class
//////////////////////////////////////////////////////////////////////////

class CSun
{
public:
    CSun();
    CSun(CBaseState* pContext /* Pass Allocated memory */);
    ~CSun();
    // Handles the next state
    void StateChanged();
    char* GetStateName();
protected:
    void DoCleanUp();
    // Pointer which holds the current state
    // Since this is and base class pointer
    // of Concentrate classes, it can holds their objects
    CBaseState* m_pState;
};


CSun objSun(new CMorning);

CSun objSun(new CMorning);
printf("\n\nSun Says Good %s !!!",objSun.GetStateName());
// inform that state has been changed
objSun.StateChanged();
printf("\n\nSun Says Good %s !!!",objSun.GetStateName());
// inform that state has been changed
objSun.StateChanged();
printf("\n\nSun Says Good %s !!!",objSun.GetStateName());
// inform that state has been changed
objSun.StateChanged();    
printf("\n\nSun Says Good %s !!!",objSun.GetStateName());


// Handles the state change
void CSun::StateChanged()
{
    if (m_pState)
    {
        // Getting Next State
        CBaseState* pState = m_pState->GetNextState();
        // de allocates the memory
        delete m_pState;
          m_pState = pState;
    }
}



Morning object’s next state:

 Collapse | Copy Code
CBaseState* CMorning::GetNextState()
{
    return new CEvening;
}
Evening object’s next state:

 Collapse | Copy Code
CBaseState* CEvening::GetNextState()
{
    return new CNight;
}
Night object’s next state:

 Collapse | Copy Code
CBaseState* CNight::GetNextState()
{
    return new CMorning;
}
