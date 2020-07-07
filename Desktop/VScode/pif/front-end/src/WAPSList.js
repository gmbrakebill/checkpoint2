import React from 'react';
import WAPS from './WAPS';

import {
    Route,
    Link
} from 'react-router-dom'

function WAPSList({waps, parent})
{
    return (
        <div>
            <Route exact path = "/waps"><div>
            <div className="center">
    {waps.map(waps => {console.log(waps);return <WAPS id = {waps.id} time_in_service = {waps.time_in_service} time_in_grade = {waps.time_in_grade} epr_data = {waps.epr_data}/> })}
                </div></div></Route>

        </div>
    )
}
export default WAPSList;